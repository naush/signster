(ns signster.view
  (:use hiccup.core)
  (:use hiccup.page-helpers))

(defn view-layout [& content]
  (html
    (doctype :xhtml-strict)
    (xhtml-tag "en"
      [:head
        [:meta {:http-equiv "Content-type"
                :content "text/html; charset=utf-8"}]
        [:title "Signster"]]
      [:body content])))

(defn view-color [text color] (html [:font {:color color} text]))

(defn color-tag [[text tag]]
  (cond (= tag "DT") (view-color (str text " [" tag "]") "CCCCCC")
        (= tag ".") (view-color (str text " [" tag "]") "FFFFFF")
        :else (view-color (str text " [" tag "]") "000000")))

(defn merge-tags [pos-tagged] (reduce #(str %1 " " %2) pos-tagged))

(defn view-output
  [{sentence :sentence
    pos-tagged :pos-tagged}]
    (view-layout
      [:h2 "You have entered"]
      [:p.output_sentence sentence]
      [:p.output_pos_tagged (merge-tags (map color-tag pos-tagged))]
      [:a.action {:href "/"} "Return"]))

(defn view-input []
  (view-layout
    [:h2 "Please enter your sentence"]
    [:form {:method "post" :action "/"}
      [:input {:type "text" :name "sentence"}]
      [:input {:type "submit" :name "submit" :value "Submit"}][:br]]))

(defn view-error []
  (view-layout
    [:h2 "Page Not Found"]))
