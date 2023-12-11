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
        def findSpecialInteger(self, arr: List[int]) -> int:
        if len(arr) < 2:
        return arr[0]
        result = 0
        percent = int(len(arr) * 0.25)
        count_map = {}

        for i in arr:
        count_map[i] = count_map.get(i, 0) + 1

        for key, count in count_map.items():
        if count > percent:
        result = key

        return result

