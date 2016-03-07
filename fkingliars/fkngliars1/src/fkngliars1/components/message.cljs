(ns fkngliars1.components.message
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [reagent.core :as reagent]
   [fkngliars1.state :as state :refer [app-state]]
   [fkngliars1.utils :as utils]))

(defn game-over-component
  []
  [:div
   [:p.game-over "Game Over"]
   [:p.assesment (utils/final-assesment)]])

(defn candidate-quote-component
  [{:keys [candidate_id quote]}]
  [:blockquote {:data-candidate-id candidate_id} quote])

(defn quote-component
  []
  (let [hasQuote? (< 0  (count (:quotes @app-state)))
        quote (when hasQuote? (utils/select-random-quote))]
    [:div.quote-container
     (if-not (nil? quote)
       [candidate-quote-component quote]
       [game-over-component])]))

(defn score-component
  [label key]
  [:div.score-container
   [:h3.label label]
   [:h2.score (get-in @app-state [:score key])]])

(defn message-component
  []
  [:div.message-container
   [:div.col-xs-2
    [score-component "Detected" :right]]
   [:div.col-xs-8
    [quote-component]]
   [:div.col-xs-2
    [score-component "Missed" :wrong]]])
