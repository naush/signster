(ns signster.translator
  (:use signster.nlp))

(def get-sentences (make-sentence-detector "models/EnglishSD.bin.gz"))
(def tokenize (make-tokenizer "models/EnglishTok.bin.gz"))
(def pos-tag (make-pos-tagger "models/tag.bin.gz"))
(def chunker (make-treebank-chunker "models/EnglishChunk.bin.gz"))
(def name-find (make-name-finder "models/namefind/person.bin.gz" "models/namefind/organization.bin.gz"))

(defn translate [sentence] (reduce #(str %1 %2) (pos-tag (tokenize sentence))))
