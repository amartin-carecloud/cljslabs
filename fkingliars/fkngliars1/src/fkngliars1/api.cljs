(ns fkngliars1.api
  (:require [reagent.core :as reagent :refer [atom]]))

(def api-candidates-url "https://fckingliars.firebaseio.com/candidates.json")
(def api-quotes-url "https://fckingliars.firebaseio.com/quotes.json")

(defn get-resource
  "Helper function that makes an ajax GET request to the url provided and 
adds the data to the app-state"
  [url handler-fn]
  (.success (.get js/$ url) handler-fn))

