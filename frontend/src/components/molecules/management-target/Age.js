import React from "react";
import { dateFormatting } from "../../../mapper/simpleMapper";
import { getOriginalAge } from "../../../services/TargetService";
import { Text } from "../../atoms/Text";

export function Age(props) {
  var age = getOriginalAge(props.birth);
  var formatted = dateFormatting(props.birth);
  const result = formatted + " (만 " + age + "세)";

  return (
    <>
      <Text label={result} />
    </>
  );
}
