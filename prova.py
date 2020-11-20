import nltk
from nltk import load_parser

#sentence = 'Angus gives a bone to every dog'.split()

#sentence = 'You are imagining things'.split()
#sentence = 'There is a price on my head'.split()
sentence = 'your big opportunity is flying out of here'.split()

cp = load_parser('cfgrammar2.fcfg', trace=0)


for tree in cp.parse(sentence):
    print(tree.label()['SEM'])


