(ns fkngliars1.utils
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [reagent.core :as reagent]
   [cljs.core.async :as async :refer [timeout chan <!]]
   [fkngliars1.state :as state :refer [app-state]]))


(defn toggle-candidate-animation
  [id]
  (swap! app-state assoc-in [:animate id :toggle] true)
  (let [ch (timeout 1000)]
    (go (<! ch)
        (swap! app-state assoc-in [:animate id :toggle] false))))

(defn record-score
  [isCorrect?]
  (if isCorrect?
    (swap! app-state update-in [:score :right] inc)
    (swap! app-state update-in [:score :wrong] inc)))

(defn select-random-quote
  []
  (let [hasQuote? (< 0 (count (:quotes @app-state)))
        quote (when hasQuote? (first (:quotes @app-state)))]
    (swap! app-state assoc-in [:tracker :current-quote] quote)
    quote))

(defn remove-quote-from-list
  []
  (let [current-quote (get-in @app-state [:tracker :current-quote])
        filtered-quotes (vec (filter #(not= % current-quote) (:quotes @app-state)))]
    (swap! app-state assoc-in [:quotes] filtered-quotes)))

(defn final-assesment
  []
  (let [{:keys [right wrong]} (get-in @app-state [:score])
        even? (= right wrong)
        winner? (> right wrong)]
    (cond
      even?
      "Sharpen up your lie detecting skills"

      winner?
      "You're a born lie detector!"

      :else
      "Don't be such a rube!")))

(defn process-turn
  [isCorrect? candidate_id]
  (record-score isCorrect?)
  (toggle-candidate-animation candidate_id)
  (remove-quote-from-list)
  (select-random-quote))
