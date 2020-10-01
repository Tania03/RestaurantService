package com.example.demo.model;

import com.example.demo.entity.BranchData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public class HeadOffice {

    List<Branch> branches;

    @Autowired
    BranchData branchData;

    public HeadOffice(Map<String, Branch> branchMap) {
        this.branches = new ArrayList<>();
    }

    public void createBranch(){

        Branch branch;

        if(branches.size() == 0)
            branch = new Branch("1");
        else{
            Branch lastBranch = branches.get(branches.size() - 1);
            int branchId = Integer.valueOf(lastBranch.branchId) + 1;
            branch = new Branch(String.valueOf(branchId));
        }

        branchData.getBranchMap().put(branch.branchId, branch);
        branches.add(branch);
    }

    public Branch getBranchById(String branchId){
        return branchData.getBranchMap().get(branchId);
    }
    public List<Branch> getAllBranches(){
        return branches;
    }
}
