package photosort;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import static java.nio.file.StandardCopyOption.*;

public class Main {


    public static void main (String[] args) throws IndicoException, IOException {
        Indico indico  = new Indico("ce80c3c09f3135a4a7c872c994cf0815");

        String dirname = "/home/kb/Java/JavaLabs/lab6/foto";
        File folder = new File(dirname);

        if(!folder.exists()){
            throw new FileNotFoundException();
        }

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (!listOfFiles[i].isFile()) {
                throw new IllegalArgumentException();
            }

            IndicoResult single = indico.imageRecognition.predict(listOfFiles[i]);
            Map<String,Double> result = single.getImageRecognition();
            //System.out.println(result);

            Map.Entry<String, Double> maxEntry = null;

            for (Map.Entry<String, Double> entry : result.entrySet())
            {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                {
                    maxEntry = entry;
                }
            }

            String dirName=maxEntry.getKey().toString();

            //Files.copy(new File ("/home/kb/Java/JavaLabs/lab6/foto"+listOfFiles[i]), new File ("/home/kb/Java/JavaLabs/lab6/foto/sorted"+"/"+listOfFiles[i]), REPLACE_EXISTING);
            FileUtils.copyFile(listOfFiles[i], new File ("/home/kb/Java/JavaLabs/lab6/foto"+"/"+dirName+"/"+listOfFiles[i].getName()));


        }



    }
}
