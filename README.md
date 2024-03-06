# Dynamic Programming vs. Branch and Bound for Partition Problem Analysis

## Overview
This repository contains an experimental analysis of Dynamic Programming (DP) and Branch and Bound (BnB) algorithms applied to the partition problem. The partition problem aims to divide a set of positive integers into two subsets with equal sums, a challenge classified as NP-Complete.

## Experiment
The experiment was conducted across datasets of varying sizes (small, medium, large) containing integers within a specified range. The objective was to evaluate execution time and memory efficiency, providing insights into each algorithm's performance under different scenarios.

## Usage
- Generate random test cases by running `tc.py`
- Run the algorithms against the generated test cases by running `tester.java`

## Results
- **Dynamic Programming** showed minimal increase in execution time as dataset size increased, consistent with its polynomial time complexity *O(n\*sum)*. Memory complexity is also *O(n\*sum)* due to the table used for tracking possible sums.
- **Branch and Bound** exhibited significant time increases for larger datasets, suggesting exponential worst-case time complexity. The efficiency of pruning plays a crucial role in performance, potentially making it faster than DP in best-case scenarios but significantly slower in others.

## Conclusion
DP offers consistent performance across various dataset sizes, making it suitable for problems where polynomial time solutions are feasible. BnB can be faster for smaller datasets but risks exponential time complexity for larger ones, highlighting the need for careful consideration based on dataset characteristics.

## Reference
For implementation details and experimental setup, visit the GitHub link: [https://github.com/sulthanftr/te2-daa.git](https://github.com/sulthanftr/te2-daa.git)
