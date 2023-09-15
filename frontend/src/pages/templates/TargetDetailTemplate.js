import React from "react";
import { PrivacyInformation } from "../../components/organisms/management-target/PrivacyInformation";
import { ManagementHistory } from "../../components/organisms/management-target/ManagementHistory";
import { UsageComparison } from "../../components/organisms/management-target/UsageComparison";

export const TargetDetailTemplate = (props) => {
  const managementHistory = props.managementHistory;
  const targetInformation = props.targetInformation;
  const targetUsage = props.targetUsage;

  return (
    <>
      <PrivacyInformation data={targetInformation} />
      <UsageComparison data={targetUsage} />
      <ManagementHistory data={managementHistory} />
    </>
  );
};
