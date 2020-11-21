import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.lexicon.italian.*;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;
import simplenlg.features.italian.ItalianLexicalFeature;

import java.io.*;s
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String param = "imagining";

        String command = "python /c start python ../../Python/TLN-Mazzei/prova.py";
        Process p = Runtime.getRuntime().exec(command + param );

        //Runtime.getRuntime().exec(new String[]{"../../Python/TLN-Mazzei/prova.py","imagining"});

        Scanner s = new Scanner(new File("./src/fol.txt"));

        while(s.hasNext()){
            System.out.println(s.next());
        }

    }

}

