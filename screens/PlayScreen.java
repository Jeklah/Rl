/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rltut.screens;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;
import java.awt.Color;
import rltut.Creature;
import rltut.StuffFactory;
import rltut.World;
import rltut.WorldBuilder;
import rltut.FieldOfView;
import java.util.List;
import java.util.ArrayList;
import rltut.Item;
import rltut.Tile;

/**
 *
 * @author arthur
 */
public class PlayScreen implements Screen {

    private World world;
    private Creature player;
    private int screenWidth;
    private int screenHeight;
    private List<String> messages;
    private FieldOfView fov;
    private Screen subscreen;

    public void createWorld() {
        world = new WorldBuilder(90, 32, 5).makeCaves().build();
    }

    private void createCreatures(StuffFactory creatureFactory) {
        player = creatureFactory.newPlayer(messages, fov);

        for (int z = 0; z < world.depth(); z++) {
            for (int i = 0; i < 8; i++) {
                creatureFactory.newFungus(z);
            }

            for (int i = 0; i < 20; i++) {
                creatureFactory.newBat(z);
            }

            for (int i = 0; i < z; i++) {
                creatureFactory.newZombie(z, player);
            }
        }
    }

    public void createItems(StuffFactory factory) {
        for (int z = 0; z < world.depth(); z++) {
            for (int i = 0; i < world.width() * world.height() / 20; i++) {
                factory.newRock(z);
            }
            factory.newFruit(z);
            factory.newEdibleWeapon(z);
            factory.newBread(z);
            factory.randomArmour(z);
            factory.randomWeapon(z);
            factory.randomWeapon(z);
        }
        factory.newVictoryItem(world.depth() - 1);
    }

    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 23;
        messages = new ArrayList<String>();
        createWorld();
        fov = new FieldOfView(world);

        StuffFactory stuffFactory = new StuffFactory(world);
        createCreatures(stuffFactory);
        createItems(stuffFactory);
    }

    public int getScrollX() {
        return Math.max(0, Math.min(player.x - screenWidth / 2, world.width() - screenWidth));
    }

    public int getScrollY() {
        return Math.max(0, Math.min(player.y - screenHeight / 2, world.height() - screenHeight));
    }

    private String hunger() {
        if (player.food() < 100) {
            return "Starving";
        } else if (player.food() < 300) {
            return "Hungry";
        } else if (player.food() > player.maxFood() * 0.95) {
            return "Stuffed";
        } else if (player.food() > player.maxFood() * 0.85) {
            return "Full";
        } else {
            return "";
        }
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        int left = getScrollX();
        int top = getScrollY();

        displayTiles(terminal, left, top);
        displayMessages(terminal, messages);
        String stats = String.format(" %3d/ %3d hp", player.hp(), player.maxHp(), hunger());
        terminal.write(stats, 1, 23);

        if (subscreen != null) {
            subscreen.displayOutput(terminal);
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
                player.moveBy(-1, 0, 0);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
                player.moveBy(1, 0, 0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
                player.moveBy(0, -1, 0);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
                player.moveBy(0, 1, 0);
                break;
            case KeyEvent.VK_Y:
                player.moveBy(-1, -1, 0);
                break;
            case KeyEvent.VK_U:
                player.moveBy(1, -1, 0);
                break;
            case KeyEvent.VK_B:
                player.moveBy(-1, 1, 0);
                break;
            case KeyEvent.VK_N:
                player.moveBy(1, 1, 0);
                break;
            case KeyEvent.VK_E:
                subscreen = new EatScreen(player);
                break;
            case KeyEvent.VK_W:
                subscreen = new EquipScreen(player);
                break;
        }
        switch (key.getKeyChar()) {
            case 'g':
            case ',':
                player.pickupItem();
                break;
            case '<':
                if (userIsTryingToExit()) {
                    return userExits();
                } else {
                    player.moveBy(0, 0, -1);
                    break;
                }
            case '>':
                player.moveBy(0, 0, 1);
                break;
        }
        if (subscreen == null) {
            world.update();
        }
        if (player.hp() < 1) {
            return new LoseScreen();
        }
        return this;
    }

    private boolean userIsTryingToExit() {
        return player.z == 0 && world.tile(player.x, player.y, player.z) == Tile.STAIRS_UP;
    }

    private Screen userExits() {
        for (Item item : player.inventory().getItems()) {
            if (item != null && item.name().equals("teddy bear")) {
                return new WinScreen();
            }
        }
        return new LoseScreen();
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {

        fov.update(player.x, player.y, player.z, player.visionRadius());
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                if (player.canSee(wx, wy, player.z)) {
                    terminal.write(world.glyph(wx, wy, player.z), x, y, world.color(wx, wy, player.z));
                } else {
                    terminal.write(fov.tile(wx, wy, player.z).glyph(), x, y, Color.darkGray);
                }
            }
        }
    }

    private void displayMessages(AsciiPanel terminal, List<String> messages) {
        int top = screenHeight - messages.size();
        for (int i = 0; i < messages.size(); i++) {
            terminal.writeCenter(messages.get(i), top + i);
        }
        messages.clear();
    }

}
