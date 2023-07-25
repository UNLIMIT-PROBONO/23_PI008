import React from "react";
import logo from "../../assets/logo.svg";
import "../css/Logo.css";

export const TogetherLogo = () => {
  // 임시 로고 사용중
  return (
    <div class="centeredLogo">
      <img src={logo} width="150px" height="150px" />
      <span>아울러</span>
    </div>
  );
};
