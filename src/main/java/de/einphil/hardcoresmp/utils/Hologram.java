package de.einphil.hardcoresmp.utils;


import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.TextDisplay;
import org.bukkit.util.Transformation;
import org.joml.Vector3f;
import org.bukkit.Color;


public class Hologram {
    private TextDisplay display;
    public Hologram(Location location, Display.Billboard billboard, boolean shadow) {
        this.display = location.getWorld().spawn(location, TextDisplay.class);
        this.display.setBillboard(billboard);
        this.display.setShadowed(shadow);
    }

    public void setText(String text) {
        this.display.setText(text);
    }

    public void setScale(Vector3f scale) {
        var transformation = new Transformation(this.display.getTransformation().getTranslation(), this.display.getTransformation().getLeftRotation(), scale, this.display.getTransformation().getRightRotation());
    }
    public void setTranslation(Vector3f translation) {
        var transformation = new Transformation(translation, this.display.getTransformation().getLeftRotation(), this.display.getTransformation().getScale(), this.display.getTransformation().getRightRotation());
    }

    public void teleport(Location location) {
        this.display.teleport(location);
    }

    public void setBackground(Color color) {
        this.display.setBackgroundColor(color);
    }

    public TextDisplay getDisplay() {
        return this.display;
    }
}
