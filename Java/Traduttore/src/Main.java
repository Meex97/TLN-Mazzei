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

        Lexicon lexIta = new ITXMLLexicon();
        NLGFactory nlgFactory = new NLGFactory(lexIta);
        Realiser realiser = new Realiser();

        Scanner s = new Scanner(new File("./src/fol.txt"));
        String str = "";

        while(s.hasNext()){
            str = str + " " + s.next();
        }
        //System.out.println(str);

        String delims = "[ .,?!&()]+";
        String[] tokens = str.split(delims);
        PhraseElement tmp = null;

        SPhraseSpec phrase = nlgFactory.createClause();
        Vocabulary v = new Vocabulary();

        VPPhraseSpec ce = nlgFactory.createVerbPhrase("c'è");
        phrase.setVerbPhrase(ce);

        for(String x : tokens) {
            if (!(x.length() == 1) && !x.equals("exists") && !x.equals("tense") && !x.equals("adjPoss") && !x.equals("adj") && !x.equals("compl")) {
                //System.out.println(x);

                tmp = v.translate(phrase, tmp, x);
            }
        }

        System.out.println(realiser.realiseSentence(phrase));

    }

}

