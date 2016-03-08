(ns houseofliars.api
  (:require [reagent.core :as reagent :refer [atom]]))

(def api-candidates-url "https://houseofliars.firebaseio.com/candidates.json")
(def api-quotes-url "https://houseofliars.firebaseio.com/quotes.json")

(defn get-resource
  "Helper function that makes an ajax GET request to the url provided. Takes a url and handler-fn.
The handler-fn handles the data on success"
  [url handler-fn]
  ;; Add your code here

  )

