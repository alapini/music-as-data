;; Jon Vlachoyiannis 07/03/2011
;; jon@emotionull.com

(ns music-as-data.core
  (:import [ddf.minim Minim]
		   [ddf.minim.signals SquareWave]
		   [ddf.minim.signals SineWave])
  (:use [rosado.processing]
		[rosado.processing.applet])
  (:use [music-as-data.mad]
		[music-as-data.elements]
		[music-as-data.globals]
		[music-as-data.signalsnotes]))


(defn setup []
  "Runs once."
  (swap! *minim* (fn [minim] (Minim. *applet*)))
  (swap! *outp* (fn [out]
				  (.getLineOut @*minim*)))
  (swap! *sine* (fn [out]
				  (new SineWave 440 1 (.sampleRate @*outp*)))))

(defn draw []
  (background-float 124))

(defapplet main :title "Music as Data"
  :setup setup :draw draw :size [200 200])

(defn start [applet]
  (run applet))

(defn end [applet]
  (stop applet))

;; Create notes and load samples
;; after system started
(create-notes)

;;(defsample kick "KickDrums1/kickdrum6.wav")
(defsample kick2 "KickDrums4/kickdrum154.wav")
;;(defsample snare "SnareDrums1/snaredrum2.wav")
(defsample snare2 "DistortedSnares2/distortedsnare52.wav")
(defsample hihat "HiHats1/hihat2.wav")

