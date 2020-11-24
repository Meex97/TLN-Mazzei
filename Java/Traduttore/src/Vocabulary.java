import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.lexicon.italian.*;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;
import simplenlg.features.italian.ItalianLexicalFeature;

public class Vocabulary {

    private boolean hasSubj = false;
    private boolean hasVerb = false;
    private final Lexicon lexIta = new ITXMLLexicon();
    private final NLGFactory nlgFactory = new NLGFactory(lexIta);
    private String unknow = "";

    public PhraseElement translate(SPhraseSpec phrase, PhraseElement tmp, String word){

        boolean reset = true;
        String x = unknow + word;

        switch (x) {
            case "image":
                tmp = nlgFactory.createVerbPhrase("immaginare");
                phrase.setVerb(tmp);
                hasVerb = true;
                break;
            case "you":
                tmp = nlgFactory.createNounPhrase("tu");
                this.addName(phrase, tmp);
                break;
            case "things":
                tmp = nlgFactory.createNounPhrase("il", "cosa");
                tmp.setPlural(true);
                this.addName(phrase, tmp);
                break;
            case "PresCont":
                phrase.setFeature(Feature.PROGRESSIVE, true);
                break;
            case "opportunity":
                tmp = nlgFactory.createNounPhrase("opportunità");
                tmp.setFeature(LexicalFeature.GENDER, Gender.FEMININE);
                tmp.addPreModifier("il");
                this.addName(phrase, tmp);
                break;
            case "big":
                WordElement grande_w = lexIta.getWord("grande", LexicalCategory.ADJECTIVE);
                grande_w.setFeature(ItalianLexicalFeature.QUALITATIVE, true);
                tmp.addModifier(grande_w);
                break;
            case "your":
                AdjPhraseSpec tuo = nlgFactory.createAdjectivePhrase("tuo");
                tmp.addModifier(tuo);
                break;
            case "fly":
                tmp = nlgFactory.createVerbPhrase("volare");
                phrase.setVerb(tmp);
                hasVerb = true;
                break;
            case "outofhere":
                tmp = nlgFactory.createPrepositionPhrase("via di", "qui");
                phrase.addPostModifier(tmp);
                break;
            case "price":
                tmp = nlgFactory.createNounPhrase("un", "taglia");
                addName(phrase, tmp);
                break;
            case "head":
                tmp = nlgFactory.createNounPhrase("testa");
                tmp.setFeature(LexicalFeature.GENDER, Gender.FEMININE);
                tmp.addPreModifier("il");
                addName(phrase, tmp);
                break;
            case "my":
                AdjPhraseSpec mia = nlgFactory.createAdjectivePhrase("mio");
                tmp.addModifier(mia);
                break;
            case "over":
                if (tmp instanceof NPPhraseSpec) {
                    ((NPPhraseSpec) tmp).setSpecifier("sopra");
                }
                break;


            default:
                unknow = unknow + word;
                reset = false;
                break;

        }

        if (reset) {
            unknow = "";
        }

        return tmp;
    }

    private void addName(SPhraseSpec phrase, PhraseElement tmp) {
        if (!hasSubj) {
            phrase.setSubject(tmp);
            hasSubj = true;
        } else {
            phrase.setObject(tmp);
        }
    }

    public boolean isVerbSetted() {
        return hasVerb;
    }
}
