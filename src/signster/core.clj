(ns signster.core
  (:use ring.adapter.jetty)
  (:use ring.middleware.params)
  (:use ring.middleware.reload)
  (:use ring.middleware.stacktrace)
  (:use signster.translator)
  (:use signster.view)
  (:gen-class))

(defn view [params]
  (let [sentence (params "sentence")]
    (if sentence
      (let [tokenized (tokenize sentence)]
        (view-output
          {:sentence sentence
           :pos-tagged (pos-tag tokenized)}))
      (view-input))))

(defn handler [{uri :uri params :params}]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (cond
              (= uri "/") (view params)
              :else (view-error))})

(def app
  (-> #'handler
    (wrap-reload '(signster.core))
    (wrap-stacktrace)
    (wrap-params)))

(defn -main [& args] (run-jetty app {:port 9001}))
