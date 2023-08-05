import React from "react";
import { Text } from "../../atoms/Text";
import { TgtDatePicker } from "../../molecules/calendar/TgtDatePicker";
import InputField from "../../atoms/InputField";
import { Col, Row } from "antd";
import { ModalButton } from "../../atoms/ModalButton";
import { ScheduleInformation } from "../../molecules/calendar/modal/ScehduleInformation";
import styled from "styled-components";

const ModalWrap = styled.div`
  width: 100vw;
  z-index: 1;
`;

const ModalBackGround = styled.div`
  width: 50%;
  height: 120vh;
  position: absolute;
  align-content: center;
  bottom: 0;
  left: 0;
  z-index: 2;
`;

const ModalContainer = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-radius: 2rem;
  gap: 2rem;
  padding: 3.6rem 0;
  border: 1px solid var(--color-white);
  background-color: white;
  position: absolute;
  left: 2rem;
  top: 30rem;
  width: 90%;
  z-index: 10000;
`;

export const ScheduleModal = (props) => {
  var isOpen = props.isOpen;
  const closeModal = props.closeModal;
  const sendForm = props.sendForm;

  return (
    <>
      {isOpen && (
        <ModalWrap>
          <ModalBackGround>
            <ModalContainer>
              <Row>
                <Text label="일정 추가" />
              </Row>

              <Row>
                <TgtDatePicker />
              </Row>
              <ScheduleInformation />
              <Row>
                <Col>
                  <ModalButton label="생성" onClick={sendForm} />
                </Col>
                <Col>
                  <ModalButton label="취소" onClick={closeModal} />
                </Col>
              </Row>
            </ModalContainer>
          </ModalBackGround>
        </ModalWrap>
      )}
    </>
  );
};
