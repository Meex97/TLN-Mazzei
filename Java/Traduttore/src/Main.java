import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.lexicon.italian.*;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;
import simplenlg.features.italian.ItalianLexicalFeature;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String param = "your big opportunity is flying out of here";

        //String command = "python /c start python ../../Python/TLN-Mazzei/prova.py";
        String command = "python /c start python /home/meex/Documents/TLN/Python/TLN-Mazzei/prova2.py";

        Process p = Runtime.getRuntime().exec(command + param );

        Scanner s = new Scanner(new File("./src/fol.txt"));

        while(s.hasNext()){
            System.out.println(s.next());
        }

    }

}

