(declare-fun IN_0 () Real)
(declare-fun f_IN_0 () Real)
(declare-fun fp_IN_0 () Real)
(declare-fun x_0 () Real)
(declare-fun x_1 () Real)
(declare-fun f_x1_0 () Real)
(declare-fun fp_x1_0 () Real)
(declare-fun return () Real)
(assert (= f_IN_0 (+ (+ (- IN_0 (/ (* (* IN_0 IN_0) IN_0) 6)) (/ (* (* (* (* IN_0 IN_0) IN_0) IN_0) IN_0) 120)) (/ (* (* (* (* (* (* IN_0 IN_0) IN_0) IN_0) IN_0) IN_0) IN_0) 5040))))
(assert (= fp_IN_0 (+ (+ (- 1 (/ (* IN_0 IN_0) 2)) (/ (* (* (* IN_0 IN_0) IN_0) IN_0) 24)) (/ (* (* (* (* (* IN_0 IN_0) IN_0) IN_0) IN_0) IN_0) 720))))
(assert (= x_0 (- IN_0 (/ f_IN_0 fp_IN_0))))
(assert (= f_x1_0 (+ (+ (- x_0 (/ (* (* x_0 x_0) x_0) 6)) (/ (* (* (* (* x_0 x_0) x_0) x_0) x_0) 120)) (/ (* (* (* (* (* (* x_0 x_0) x_0) x_0) x_0) x_0) x_0) 5040))))
(assert (= fp_x1_0 (+ (+ (- 1 (/ (* x_0 x_0) 2)) (/ (* (* (* x_0 x_0) x_0) x_0) 24)) (/ (* (* (* (* (* x_0 x_0) x_0) x_0) x_0) x_0) 720))))
(assert (= x_1 (- x_0 (/ f_x1_0 fp_x1_0))))
(assert (= return x_1))
(assert (and (> (+ IN_0 0.2) 0) (< IN_0 0.2)))
(assert (not (< return 0.1)))
(check-sat)
(get-model)