import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class ShapeDrawer extends JPanel {
    private Shape currentShape;

    public ShapeDrawer() {
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentShape != null) {
                    currentShape = new Rectangle(e.getX(), e.getY(), 50, 50);
                    repaint();
                }
            }
        });
    }

    public void drawShape(String shapeType) {
        switch (shapeType.toLowerCase()) {
            case "circle":
                currentShape = new Ellipse2D.Float(50, 50, 100, 100);
                break;
            case "rectangle":
                currentShape = new Rectangle(50, 50, 100, 100);
                break;
            // Add more shapes as needed
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentShape != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.draw(currentShape);
        }
    }
}
