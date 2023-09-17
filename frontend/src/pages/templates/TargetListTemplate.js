import React from "react";
import { TargetList } from "../../components/molecules/management-target/TargetList";

export const TargetListTemplate = (props) => {
  return (
    <>
      <TargetList sources={props.targetList} onClickRow={props.onClickRow} />
    </>
  );
};
