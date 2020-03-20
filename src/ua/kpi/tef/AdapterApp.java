package ua.kpi.tef;

public class AdapterApp {
    public static void main(String[] args) {
    VectorGraphicsInterface v1 = new VectorAdapterFromRaster1();
    v1.drawLine();
    v1.drawSquare();
    VectorGraphicsInterface v2 = new VectorAdapterFromRaster2(new RasterGraphics());
    v2.drawLine();
    v2.drawSquare();
    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}

class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Draw line");
    }
    void drawRasterSquare(){
        System.out.println("Draw square");
    }
}
class VectorAdapterFromRaster1 extends RasterGraphics implements VectorGraphicsInterface{
    public void drawLine(){
        drawRasterLine();
    }
    public void drawSquare(){
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics raster = null;

    public VectorAdapterFromRaster2(RasterGraphics raster) {
        this.raster = raster;
    }

    public void drawLine(){
       raster.drawRasterLine();
    }
    public void drawSquare(){
       raster.drawRasterSquare();
    }
}