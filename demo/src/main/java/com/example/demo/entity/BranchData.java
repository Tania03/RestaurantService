package com.example.demo.entity;

import com.example.demo.model.Branch;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 07/08/20
 */

@Getter
public class BranchData {

    Map<String, Branch> branchMap;

    public BranchData() {
        this.branchMap = new HashMap<>();
    }


}
