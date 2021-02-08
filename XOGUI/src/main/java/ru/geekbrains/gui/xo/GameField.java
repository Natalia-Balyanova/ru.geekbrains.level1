package ru.geekbrains.gui.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class GameField extends JPanel {
    private final int CELL_SIZE = 120;
    final int MAP_SIZE = 3;

    byte[][] map;
    boolean isGameOn;

    public GameField() {
        this.addMouseListener(new MouseAdapter() {
                                  @Override
                                  public void mouseReleased(MouseEvent e) {
                                      while (isGameOn)
                                          if (e.getButton() == MouseEvent.BUTTON1) {
                                              int cellX = e.getX() / CELL_SIZE;
                                              int cellY = e.getY() / CELL_SIZE;
                                              System.out.println("You turn on " + e.getX() + " " + e.getY() + " px  ");
                                              if (setDotTo(cellX, cellY, (byte) 1)) {
                                                  checkDraw();
                                                  if (winPlayer()) { //проверка и вывод победы
                                                      System.out.println("player win");
                                                      break;
                                                  }
                                              }
                                              aiTurn();
                                              if (winAI()) System.out.println("ai win"); //победа ИИ
                                              break;
                                          }
                                  }
                              }
        );
        startGame();
    }

    public void checkDraw() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == 0) {
                    return;
                }
            }
        }
        isGameOn = false;
        repaint();
    }

    public void startGame() {
        this.map = new byte[MAP_SIZE][MAP_SIZE];
        this.isGameOn = true;
        repaint();

    }

    public void aiTurn() {
        if (isGameOn) {
            for (int i = 0; i < MAP_SIZE; i++) //блокировка хода игрока и поиск решения
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (setDotTo(i, j, (byte) 2)) {
                        map[i][j] = (byte) 2;
                        if (winAI()) return;
                        map[i][j] = 0;
                    }
                }
            for (int i = 0; i < MAP_SIZE; i++)
                for (int j = 0; j < MAP_SIZE; j++) {
                    if (setDotTo(i, j, (byte) 2)) {
                        map[i][j] = (byte) 1;
                        if (winPlayer()) {
                            map[i][j] = (byte) 2;
                            return;
                        }
                        map[i][j] = 0;
                    }
                }
            int cellX, cellY;
            do {
                cellX = (int) (Math.random() * MAP_SIZE);
                cellY = (int) (Math.random() * MAP_SIZE);
            } while (!setDotTo(cellX, cellY, (byte) 2));
            repaint();
            checkDraw();
        }
    }

    public boolean winPlayer() { //было удобнее разбить на 2 метода, чтобы не запутаться при опрокидывании дота
        for (int i = 0; i < MAP_SIZE; i++) { //код для проверки 3на3
            if (map[i][0] == (byte) 1 && map[i][1] == (byte) 1 && map[i][2] == (byte) 1)
                return true;
            if (map[0][i] == (byte) 1 && map[1][i] == (byte) 1 && map[2][i] == (byte) 1)
                return true;
            if (map[i][0] == (byte) 1 && map[1][1] == (byte) 1 && map[MAP_SIZE - 1 - i][2] == (byte) 1)
                return true;
        }
        return false;
    }

    public boolean winAI() {
        for (int i = 0; i < MAP_SIZE; i++) { //код для проверки 3на3
            if (map[i][0] == (byte) 2 && map[i][1] == (byte) 2 && map[i][2] == (byte) 2)
                return true; //д
            if (map[0][i] == (byte) 2 && map[1][i] == (byte) 2 && map[2][i] == (byte) 2)
                return true;
            if (map[i][0] == (byte) 2 && map[1][1] == (byte) 2 && map[MAP_SIZE - 1 - i][2] == (byte) 2)
                return true;
        }
        return false;
    }

    boolean setDotTo(int cellX, int cellY, byte dot) {
        if (cellX < 0 || cellY < 0 || cellX >= MAP_SIZE || cellY >= MAP_SIZE) {
            return false;
        }
        if (map[cellX][cellY] == 0) {
            map[cellX][cellY] = dot;
            repaint();
            return true;
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, MAP_SIZE * CELL_SIZE, MAP_SIZE * CELL_SIZE);

        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                ((Graphics2D) g).setStroke(new BasicStroke(3));
                g.setColor(Color.BLACK);
                g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                if (map[i][j] == 1) {
                    ((Graphics2D) g).setStroke(new BasicStroke(6));
                    g.setColor(Color.GREEN); //поменяла местами. теперь ИИ нолик, игрок крестик
                    g.drawLine(i * CELL_SIZE + 20, j * CELL_SIZE + 20, (i + 1) * CELL_SIZE - 20, (j + 1) * CELL_SIZE - 20);
                    g.drawLine(i * CELL_SIZE + 20, (j + 1) * CELL_SIZE - 20, (i + 1) * CELL_SIZE - 20, j * CELL_SIZE + 20);

                    if (winPlayer()) { //вывод на эран сообщения о победе
                        g.setColor(Color.GREEN);
                        g.setFont(new Font("Times New Roman", Font.BOLD, 48));
                        g.drawString("You WIN!", 80, 200); //вывод посередине
                        isGameOn = false; //для блокировки мышки
                    }
                }
                    if (map[i][j] == 2) {
                    ((Graphics2D) g).setStroke(new BasicStroke(6));
                    g.setColor(Color.RED);
                    g.drawOval(i * CELL_SIZE + 10, j * CELL_SIZE + 10, CELL_SIZE - 20, CELL_SIZE - 20);

                    if (winAI()) {
                        g.setColor(Color.RED); //победил ИИ сообщение
                        g.setFont(new Font("Times New Roman", Font.BOLD, 48));
                        g.drawString("AI WIN!", 86, 100);
                        isGameOn = false;
                    }
                }
            }
        }
        if (!isGameOn && (!winPlayer())) { //добавила условие, game over при проигрыше или ничья
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times New Roman", Font.BOLD, 48));
            g.drawString("GAME OVER", 30, 200);
        }
    }
}
