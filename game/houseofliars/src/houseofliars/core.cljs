(ns houseofliars.core
  (:require [reagent.core :as reagent :refer [atom]]
            [cljsjs.jquery]
            [houseofliars.state :as state :refer [app-state]]
            [houseofliars.components.main :refer [main]]))

(enable-console-print!)


(state/initialize-app-state!)

;; "Main React Component. App initializes here"
(reagent/render-component
 [main]
 (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  (state/reset-app-state!))
