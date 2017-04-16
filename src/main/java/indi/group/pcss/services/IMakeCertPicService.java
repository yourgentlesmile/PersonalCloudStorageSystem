package indi.group.pcss.services;

import java.io.OutputStream;

public interface IMakeCertPicService {
    String getCerPic(int width, int height, OutputStream os);
}
