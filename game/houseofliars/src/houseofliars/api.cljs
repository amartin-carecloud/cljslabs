(ns houseofliars.api
  (:require [reagent.core :as reagent :refer [atom]]))

(def api-candidates-url "https://fckingliars.firebaseio.com/candidates.json")
(def api-quotes-url "https://fckingliars.firebaseio.com/quotes.json")

(defn get-resource
  "Helper function that makes an ajax GET request to the url provided. Takes a url and handler-fn.
The handler-fn handles the data on success"
  [url handler-fn]
  (.success (.get js/$ url) handler-fn))

