import React from "react";
import { PrivacyInformation } from "../../components/organisms/management-target/PrivacyInformation";
import { ManagementHistory } from "../../components/organisms/management-target/ManagementHistory";
import { UsageComparison } from "../../components/organisms/management-target/UsageComparison";

export const TargetDetailTemplate = (props) => {
  const managementHistory = props.data.managementHistory;
  const targetInfomation = props.data.targetInfomation;
  const targetUsage = props.data.targetUsage;

  return (
    <>
      <PrivacyInformation data={targetInfomation} />
      <UsageComparison data={targetUsage} />
      <ManagementHistory data={managementHistory} />
    </>
  );
};
