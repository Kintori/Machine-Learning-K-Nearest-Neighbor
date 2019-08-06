# Machine Learning: K Nearest Neighbor Algorithm
What is the K Nearest Neighbor Algorithm?: <br/>
https://towardsdatascience.com/machine-learning-basics-with-the-k-nearest-neighbors-algorithm-6a6e71d01761

## How to Compile and Run
Assuming you have installed the [Java JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) and it is properly set up in your PATH or environment variables, the project can be compiled by running `javac Knearestneighbor.java` and run by running `java Knearestneighbor.java`. The algorithm is testing against the famous [iris dataset](https://archive.ics.uci.edu/ml/datasets/iris).

The resulting output should look like: <br/>
```
Running K Nearest Neighbor Algorithm:

The Testing Samples are:
[4.9, 3.0, 1.4, 0.2, 0.0]
[4.9, 2.4, 3.3, 1.0, 0.0]
[4.9, 2.5, 4.5, 1.7, 0.0]

Getting 1 KNN for test sample 1...
The KNN for test sample 1 are:
Iris Sample at index 11: [4.8, 3.0, 1.4, 0.1, 1.0]
The estimated answer is: 1.0
Thus the test sample is Iris-setosa

Getting 1 KNN for test sample 2...
The KNN for test sample 2 are:
Iris Sample at index 91: [5.0, 2.3, 3.3, 1.0, 2.0]
The estimated answer is: 2.0
Thus the test sample is Iris-versicolor

Getting 1 KNN for test sample 3...
The KNN for test sample 3 are:
Iris Sample at index 82: [5.4, 3.0, 4.5, 1.5, 2.0]
The estimated answer is: 2.0
Thus the test sample is Iris-versicolor

Getting 3 KNN for test sample 1...
The KNN for test sample 1 are:
Iris Sample at index 11: [4.8, 3.0, 1.4, 0.1, 1.0]
Iris Sample at index 44: [4.8, 3.0, 1.4, 0.3, 1.0]
Iris Sample at index 8: [4.9, 3.1, 1.5, 0.1, 1.0]
The estimated answer is: 1.0
Thus the test sample is Iris-setosa

Getting 3 KNN for test sample 2...
The KNN for test sample 2 are:
Iris Sample at index 91: [5.0, 2.3, 3.3, 1.0, 2.0]
Iris Sample at index 96: [5.1, 2.5, 3.0, 1.1, 2.0]
Iris Sample at index 58: [5.0, 2.0, 3.5, 1.0, 2.0]
The estimated answer is: 2.0
Thus the test sample is Iris-versicolor

Getting 3 KNN for test sample 3...
The KNN for test sample 3 are:
Iris Sample at index 82: [5.4, 3.0, 4.5, 1.5, 2.0]
Iris Sample at index 57: [5.2, 2.7, 3.9, 1.4, 2.0]
Iris Sample at index 88: [5.5, 2.6, 4.4, 1.2, 2.0]
The estimated answer is: 2.0
Thus the test sample is Iris-versicolor

Getting 5 KNN for test sample 1...
The KNN for test sample 1 are:
Iris Sample at index 11: [4.8, 3.0, 1.4, 0.1, 1.0]
Iris Sample at index 44: [4.8, 3.0, 1.4, 0.3, 1.0]
Iris Sample at index 8: [4.9, 3.1, 1.5, 0.1, 1.0]
Iris Sample at index 33: [4.9, 3.1, 1.5, 0.1, 1.0]
Iris Sample at index 36: [4.9, 3.1, 1.5, 0.1, 1.0]
The estimated answer is: 1.0
Thus the test sample is Iris-setosa

Getting 5 KNN for test sample 2...
The KNN for test sample 2 are:
Iris Sample at index 91: [5.0, 2.3, 3.3, 1.0, 2.0]
Iris Sample at index 96: [5.1, 2.5, 3.0, 1.1, 2.0]
Iris Sample at index 58: [5.0, 2.0, 3.5, 1.0, 2.0]
Iris Sample at index 79: [5.5, 2.4, 3.7, 1.0, 2.0]
Iris Sample at index 78: [5.5, 2.4, 3.8, 1.1, 2.0]
The estimated answer is: 2.0
Thus the test sample is Iris-versicolor

Getting 5 KNN for test sample 3...
The KNN for test sample 3 are:
Iris Sample at index 82: [5.4, 3.0, 4.5, 1.5, 2.0]
Iris Sample at index 57: [5.2, 2.7, 3.9, 1.4, 2.0]
Iris Sample at index 88: [5.5, 2.6, 4.4, 1.2, 2.0]
Iris Sample at index 87: [5.5, 2.5, 4.0, 1.3, 2.0]
Iris Sample at index 64: [5.6, 3.0, 4.5, 1.5, 2.0]
The estimated answer is: 2.0
Thus the test sample is Iris-versicolor
```
