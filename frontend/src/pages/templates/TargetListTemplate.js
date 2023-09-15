import React from "react";
import { TargetList } from "../../components/molecules/management-target/TargetList";

export const TargetListTemplate = (props) => {
  const targetList = props.data.targetList;

  return (
    <>
      <TargetList sources={targetList} />
    </> 
  );
};
