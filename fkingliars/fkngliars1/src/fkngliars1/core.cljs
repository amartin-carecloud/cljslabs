(ns fkngliars1.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljsjs.jquery]
            [fkngliars1.state :as state :refer [app-state]]
            [fkngliars1.components.main :refer [main]]))

(enable-console-print!)

;; define your app data so that it doesn't get over-written on reload

(reagent/render-component [main]
                          (. js/document (getElementById "app")))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
