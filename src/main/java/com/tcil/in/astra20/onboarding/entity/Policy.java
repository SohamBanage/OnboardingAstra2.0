package com.tcil.in.astra20.onboarding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="POLICY")
public class Policy {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Attributes
    private String policyEngine;
    private boolean restrictSubUserEmailDomain;
    private boolean isBypassApproval;
    private boolean approveAssignedRequestOnly;
    private boolean isSelfApproval;
    private boolean showPolicy;
    private boolean exceptionLegendWithoutWorkflow;
    private boolean hotelExceptionLegendWithoutWorkflow;
    private boolean supervisorListEmailDisplay;
    private boolean resultPolicyForReseller;
    private boolean isPaymentModeFilterAtReseller;
    private boolean searchPolicyForTravelerOnly;
    private boolean overrideSupervisor;
    private String ccEmailAddresses;
    private boolean sendAutoEmailsToPolicyCCEmailsOnApproval;
    private String displayInpolicyText;
    private boolean sendSupervisorEmailInCC;
    private String replyToEmailAddresses;
    private String notesForSubmitApproval;
    private String blockedSearchResultReasonText;
    private String showAllPopupText;
    private String profileFieldMissingMsg;

}
