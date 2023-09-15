import React from "react";
import { dateFormatting } from "../../../mapper/simpleMapper";
import { Text } from "../../atoms/Text";

export const Age = (props) => {
  const birth = (props.birth)? props.birth : new Date();
  const formatted = dateFormatting(birth);
  const result = formatted + " (만 " + props.age + "세)";

  return (
    <>
      <Text label={result} />
    </>
  );
};
