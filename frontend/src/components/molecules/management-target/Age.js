import React from "react";
import { dateFormatting, getOriginalAge } from "../../../mapper/simpleMapper";
import { Text } from "../../atoms/Text";

export const Age = (props) => {
  var age = getOriginalAge(props.birth);
  var formatted = dateFormatting(props.birth);
  const result = formatted + " (만 " + age + "세)";

  return (
    <>
      <Text label={result} />
    </>
  );
};
