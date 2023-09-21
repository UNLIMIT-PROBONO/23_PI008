import React from "react";
import { MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { Button, theme } from "antd";
import { Header } from "antd/es/layout/layout";
import { Text } from "../../atoms/Text";
import { useNavigate } from "react-router";
import { sendLogout } from "../../../services/AuthService";

export const TgtHeader = (props) => {
  const collapsed = props.collapsed;
  const setCollapsed = props.setCollapsed;
  const handleCollapsing = () => {
    setCollapsed(!collapsed);
  };
  const {
    token: { colorBgContainer },
  } = theme.useToken();

  const router = useNavigate();
  const onClickLogout = () => {
    sendLogout();
    router("../");
  };

  return (
    <div>
      <Header
        style={{ padding: 0, background: colorBgContainer, width: "100%" }}
      >
        <Button
          type="text"
          icon={collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
          onClick={handleCollapsing}
          style={{
            fontSize: "16px",
            width: 64,
            height: 64,
          }}
        />
        <button
          style={{ float: "right", marginRight: "40px" }}
          onClick={onClickLogout}
        >
          <Text label="로그아웃" />
        </button>
      </Header>
    </div>
  );
};
