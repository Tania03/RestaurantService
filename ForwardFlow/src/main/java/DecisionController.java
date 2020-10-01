/**
 *  Copyright 2016 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.snapdeal.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snapdeal.engagementEngine.exceptions.DecisionAPIException;
import com.snapdeal.engagementEngine.service.IPostshipCancellationService;
import com.snapdeal.engagementEngine.service.exceptions.ResponseCodes;
import com.snapdeal.risk.core.DecisionEvaluatorManager;
import com.snapdeal.risk.dto.DecisionRequest;
import com.snapdeal.risk.dto.DecisionResponse;
import com.snapdeal.risk.dto.GoGreenRequest;
import com.snapdeal.risk.dto.GoGreenResponse;

/**
 * @version 1.0, 15-Nov-2016
 * @author pankaj.kedia
 */
@Controller
@RequestMapping("/service/risk/decision/")
public class DecisionController {

    private static final Logger          LOG = LoggerFactory.getLogger(DecisionController.class);

    @Autowired
    private DecisionEvaluatorManager     decisionEvaluatorManager;

    @Autowired
    @Qualifier("postshipCancellationServiceImpl")
    private IPostshipCancellationService postshipCancellationService;

    @RequestMapping(value = "forwardflow", method = RequestMethod.POST)
    @ResponseBody
    public DecisionResponse takeDecision(@RequestBody DecisionRequest decisionRequest) {

        DecisionResponse decisionResponse = new DecisionResponse();
        try {

            decisionResponse = decisionEvaluatorManager.evaluate(decisionRequest);
            decisionResponse.setMessage(ResponseCodes.SUCCESS.toString());
        } catch (DecisionAPIException e) {
            LOG.error("DecisionAPIException occured", e);
            decisionResponse.setMessage(e.getMessage());
            decisionResponse.setSuccessful(false);
        } catch (Exception e) {
            LOG.error("Internal Error occured", e);
            decisionResponse.setMessage(e.getMessage());
            decisionResponse.setSuccessful(false);
        }
        return decisionResponse;
    }

    @RequestMapping(value = "backwardflow", method = RequestMethod.POST)
    @ResponseBody
    public GoGreenResponse postshipCancellationGoGreenMessage(@RequestBody GoGreenRequest request) {

        GoGreenResponse response = new GoGreenResponse();
        try {
            response = postshipCancellationService.getpostshipCancellationGoGreenMessage(request);
            response.setMessage(ResponseCodes.SUCCESS.toString());
        } catch (DecisionAPIException e) {
            LOG.error("DecisionAPIException occured", e);
            response.setMessage(e.getMessage());
            response.setSuccessful(false);
        } catch (Exception e) {
            LOG.error("Internal Error occured", e);
            response.setMessage(e.getMessage());
            response.setSuccessful(false);
        }
        return response;
    }
}
