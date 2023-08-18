import React, { useEffect, useState } from "react";
import { Text } from "../../atoms/Text";
import { TgtDatePicker } from "../../molecules/calendar/TgtDatePicker";
import InputField from "../../atoms/InputField";
import { Col, Row } from "antd";
import { ModalButton } from "../../atoms/ModalButton";
import { ScheduleInformation } from "../../molecules/calendar/modal/ScehduleInformation";
import styled from "styled-components";
import { addNewSchedule } from "../../../services/ScheduleService";
import { getAllInfo } from "../../../services/TargetService";
import { toasting } from "../../../hook/UseToast";
import { ToastContainer } from "react-toastify";

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
  var [targetInfos, setTargetInfo] = useState([
    {
      targetId: 1,
      tgName: "",
    },
  ]);
  var [form, setForm] = useState({
    targetId: null,
    title: "",
    content: "",
    startDate: null,
    endDate: null,
  });

  const sendForm = () => {
    const result = addNewSchedule(form);
    if (result == true) {
      closeModal();
      toasting("일정을 추가하였습니다", "success");
    }
    toasting("일정 추가에 실패했습니다.", "warning");
  };

  const fetchTargetInfo = async () => {
    const result = await getAllInfo();
    setTargetInfo(result);
  };

  const setDateRange = (date, dateString) => {
    form.startDate = new Date(date[0]);
    form.endDate = new Date(date[1]);
  };

  const inputHandler = (data) => {
    form.title = data.title;
    form.content = data.content;
    form.targetId = data.targetId;
  };

  const fetch = () => {
    fetchTargetInfo();
  };

  useEffect(async () => {
    await fetch();
  }, []);

  return (
    <>
      {isOpen && (
        <ModalWrap>
          <ModalBackGround>
            <ModalContainer>
            <ToastContainer />
              <Row>
                <Text label="일정 추가" />
              </Row>

              <Row>
                <TgtDatePicker onChange={setDateRange} />
              </Row>

              <ScheduleInformation
                targetInfos={targetInfos}
                values={form}
                inputHandler={inputHandler}
              />

              <Row>
                <Col>
                  <ModalButton label="취소" onClick={closeModal} />
                </Col>
                <Col>
                  <ModalButton label="생성" onClick={sendForm} />
                </Col>
              </Row>
            </ModalContainer>
          </ModalBackGround>
        </ModalWrap>
      )}
    </>
  );
};