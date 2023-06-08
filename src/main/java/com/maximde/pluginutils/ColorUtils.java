package com.maximde.pluginutils;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

public class ColorUtils {

    public static Color[] generateColorsInBetweenOutAndIn(Color startColor, Color endColor, int numColors) {
        Color[] colors = new Color[numColors];
        float[] startHSB = Color.RGBtoHSB(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), null);
        float[] endHSB = Color.RGBtoHSB(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), null);
        float hueDiff = endHSB[0] - startHSB[0];
        float saturationDiff = endHSB[1] - startHSB[1];
        float brightnessDiff = endHSB[2] - startHSB[2];
        int midIndex = numColors / 2;
        for (int i = 0; i < midIndex; i++) {
            float hue = startHSB[0] + hueDiff * i / (midIndex - 1);
            float saturation = startHSB[1] + saturationDiff * i / (midIndex - 1);
            float brightness = startHSB[2] + brightnessDiff * i / (midIndex - 1);
            colors[i] = new Color(Color.HSBtoRGB(hue, saturation, brightness));
        }
        for (int i = midIndex; i < numColors; i++) {
            float hue = endHSB[0] - hueDiff * (i - midIndex) / (numColors - midIndex - 1);
            float saturation = endHSB[1] - saturationDiff * (i - midIndex) / (numColors - midIndex - 1);
            float brightness = endHSB[2] - brightnessDiff * (i - midIndex) / (numColors - midIndex - 1);
            colors[i] = new Color(Color.HSBtoRGB(hue, saturation, brightness));
        }
        return colors;
    }

    public static Color[] generateColorsInBetween(Color startColor, Color endColor, int numColors) {
        Color[] colors = new Color[numColors];
        float[] startHSB = Color.RGBtoHSB(startColor.getRed(), startColor.getGreen(), startColor.getBlue(), null);
        float[] endHSB = Color.RGBtoHSB(endColor.getRed(), endColor.getGreen(), endColor.getBlue(), null);
        float hueDiff = endHSB[0] - startHSB[0];
        float saturationDiff = endHSB[1] - startHSB[1];
        float brightnessDiff = endHSB[2] - startHSB[2];
        for (int i = 0; i < numColors; i++) {
            float hue = startHSB[0] + hueDiff * i / (numColors - 1);
            float saturation = startHSB[1] + saturationDiff * i / (numColors - 1);
            float brightness = startHSB[2] + brightnessDiff * i / (numColors - 1);
            colors[i] = new Color(Color.HSBtoRGB(hue, saturation, brightness));
        }
        return colors;
    }

    public static String generateGradientText(Color startColor, Color endColor, String text) {
        StringBuilder gradientText = new StringBuilder();
        char[] chars = text.toCharArray();
        Color[] colors = generateColorsInBetween(startColor, endColor, chars.length);
        for(int i = 0; i < chars.length; i++) {
            gradientText.append(ChatColor.of(colors[i])).append(chars[i]);
        }
        return gradientText.toString();
    }

    private String prefix = ColorUtils.generateGradientText(new Color(39, 7, 190), new Color(255, 255, 255), "| Soul >>");
    private String flugmodusAktiviert = ColorUtils.generateGradientText(new Color(190, 7, 7), new Color(255, 255, 255), "Dein Flugmodus wurde Aktiviert!");

}
