package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator = "uuidgenerator")
    @GenericGenerator(name = "uuidgenerator",strategy = "uuid2")
    @Column(name = "id",columnDefinition = "binary(16)",nullable = false,updatable = false)
    private UUID id;

}

class Solution:
        def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        m = len(grid)
        n = len(grid[0])

        rows = {}
        for r in range(m):
        row_sum = 0
        for c in range(n):
        row_sum += grid[r][c]

        rows[r] = row_sum

        cols = {}
        for c in range(n):
        col_sum = 0
        for r in range(m):
        col_sum += grid[r][c]

        cols[c] = col_sum

        res = [[0] * n for _ in range(m)]

        for r in range(m):
        for c in range(n):
        res[r][c] = rows[r] + cols[c] - (m - rows[r]) - (n - cols[c])

        return res

