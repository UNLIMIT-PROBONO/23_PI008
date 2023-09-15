import React from "react";
import { TargetList } from "../../components/molecules/management-target/TargetList";

export const TargetListTemplate = (props) => {
  console.log(props.targetList)
  return (
    <>
      <TargetList sources={props.targetList} />
    </> 
  );
};
