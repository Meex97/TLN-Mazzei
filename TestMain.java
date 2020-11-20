import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.lexicon.italian.*;
import simplenlg.realiser.*;
import simplenlg.phrasespec.*;
import simplenlg.features.*;
import simplenlg.features.italian.ItalianLexicalFeature;


public class TestMain {

    public static void main(String[] args) {
	Lexicon lexIta = new ITXMLLexicon();
	NLGFactory nlgFactory = new NLGFactory(lexIta);
	Realiser realiser = new Realiser();


	//1° frase - Tu stai immaginando cose
	
	SPhraseSpec f1 = nlgFactory.createClause();
	
	f1.setSubject("tu");
		
	f1.setVerb("immaginare");
	f1.setFeature(Feature.PROGRESSIVE, true);	
		
	NPPhraseSpec cose = nlgFactory.createNounPhrase("la", "cosa");
	cose.setPlural(true);
	f1.setObject(cose);
	
	//System.out.println(realiser.realiseSentence(f1));
	
	//2° frase - La tua grande opportunità sta volanda via di qui
	
	SPhraseSpec f2 = nlgFactory.createClause();

    NPPhraseSpec np = nlgFactory.createNounPhrase("la","opportunità");
    np.setFeature(LexicalFeature.GENDER, Gender.FEMININE);
    np.addPreModifier("tua");
    WordElement grande_w = lexIta.getWord("grande", LexicalCategory.ADJECTIVE);
    grande_w.setFeature(ItalianLexicalFeature.QUALITATIVE, true);
    np.addModifier(grande_w);
    f2.setSubject(np);

    VPPhraseSpec vp = nlgFactory.createVerbPhrase("volare");
    f2.setFeature(Feature.PROGRESSIVE, true);
    f2.setVerb(vp); //unibile

    PPPhraseSpec pp = nlgFactory.createPrepositionPhrase("via di", "qui");
    f2.addPostModifier(pp); //unibile
    
    //System.out.println(realiser.realiseSentence(f2));
	
	//3° frase - C'è una taglia sulla mia testa
	
	SPhraseSpec f3 = nlgFactory.createClause();
		
	NPPhraseSpec taglia = nlgFactory.createNounPhrase("una", "taglia");
	f3.setSubject(taglia);
	
	
	VPPhraseSpec ce = nlgFactory.createVerbPhrase("c'è");
	PPPhraseSpec testa = nlgFactory.createPrepositionPhrase("mio", "testa");
	testa.addModifier("sulla");
	ce.setFeature(LexicalFeature.GENDER, Gender.FEMININE);
	ce.addComplement(testa);
	
	f3.setVerbPhrase(ce);
	
	System.out.println(realiser.realiseSentence(f3));
	
    }

}
