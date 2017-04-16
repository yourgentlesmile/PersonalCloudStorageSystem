package indi.group.pcss.services.impl;

import javax.imageio.ImageIO;

import indi.group.pcss.services.IMakeCertPicService;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Describle:
 * This function generate valification code image with jsp
 */
public class MakeCertPicServicesImpl implements IMakeCertPicService{
    private char mapTable[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9',  };
    @Override
    public String getCerPic(int width, int height, OutputStream os) {
        if (width < 60) {
            width = 60;
        }
        if (height <= 0) {
            height = 20;
        }
        BufferedImage image = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Graphics graphics = image.getGraphics();
        graphics.setColor(new Color(0xDCDCDC));
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(java.awt.Color.black);
        graphics.drawRect(0, 0, width - 1, height - 1);
        String strEnsure = "";
        for (int i = 1; i <= 4; i++) {
            strEnsure += mapTable[(int) (mapTable.length * Math.random())];
        }
        graphics.setColor(java.awt.Color.black);
        graphics.setFont(new Font("Atlantic Inline", Font.PLAIN, 20));
        String str = strEnsure.substring(0, 1);
        graphics.drawString(str, 8, 17);
        str = strEnsure.substring(1, 2);
        graphics.drawString(str, 20, 15);
        str = strEnsure.substring(2, 3);
        graphics.drawString(str, 35, 18);
        str = strEnsure.substring(3, 4);
        graphics.drawString(str, 45, 15);
        Random random = new Random();
        for (int i = 0; i <= 10; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            graphics.drawOval(x, y, 1, 1);
        }
        graphics.dispose();
        try {
        	ImageIO.write(image, "JPEG", os);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return strEnsure;
    }
}
