package main.java.aranyaszok.gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Ennek a segitsegevel valositjuk meg a mentesnel, illetve a betoltesnel a filtert, vagyis azt, hogy milyen kiterjesztesu fajlokat mutasson/ engedjen menteni.
 * @author aranyaszok
 *
 */
public class MyFileFilter extends FileFilter
{
    private String type;

    /**
     * Az osztaly kontruktora. 
     * @param type A tipus, vagyis a kiterjesztes amely szerinte szeretnek, hogy a filter mukodjon.
     */
    public MyFileFilter(String type)
    {
        this.type = type;
    } 

    /**
     * Ez a fuggveny donti el egy fajlrol, hogy a kontruktorban megadott tipusu-e.
     */
    public boolean accept(File file)
    {  
        if(file.isDirectory())
            return true;

        String ext = getExtension(file);
        if(ext == null)
            return false;

        switch(type)
        {
            case "data":
                if(ext.equals("data"))
                    return true;
                else 
                    break;
            default:
        }

        return false;
    }

    /**
     *A "data" kiterjeszteshez tartozo leiras a FileChooser-ben
     */
    public String getDescription()
    {
        switch(type)
        {
            case "data":
                return "Ice diggers saves";
            default:
            	return "";
        }
    }

    /**
     * Egy file kiterjesztesevel ter vissza (utolso '.' utani resz)
     * @param f A vizsgalt file
     * @return A file kiterjesztese
     */
    public String getExtension(File f)
    {
        String ext = null;
        String filename = f.getName();

        int i = filename.lastIndexOf('.');

        if(i > 0 && i < filename.length() - 1)
            ext = filename.substring(i + 1).toLowerCase();

        return ext;
    }
}
