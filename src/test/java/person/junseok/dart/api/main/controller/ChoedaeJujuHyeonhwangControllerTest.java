package person.junseok.dart.api.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import person.junseok.dart.api.main.dto.SaeobBogoseoRequestDTO;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs
public class ChoedaeJujuHyeonhwangControllerTest {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;
    private RestDocumentationResultHandler restDocumentationResultHandler;

    public ChoedaeJujuHyeonhwangControllerTest() {
    }

    @Before
    public void setUp() {
        this.restDocumentationResultHandler = document("{method-name}",
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()));

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext)
                .apply(documentationConfiguration(this.restDocumentation))
                .alwaysDo(this.restDocumentationResultHandler)
                .build();
    }

    @Test
    public void choedaeJujuHyeonhwangTest() throws Exception {
        SaeobBogoseoRequestDTO saeobBogoseoRequestDTO = SaeobBogoseoRequestDTO.builder()
                .bsnsYear("2018")
                .corpCode("00126380")
                .reprtCode("11011")
                .build();

        ResultActions resultAction = mockMvc.perform(post("/choedaeJujuHyeonhwang")
                .content(objectMapper.writeValueAsString(saeobBogoseoRequestDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        //ConstrainedFields fields = new ConstrainedFields(BusinessReportDTO.class);

        resultAction.andExpect(status().isOk())
                .andDo(restDocumentationResultHandler.document(
                        requestFields(
                                attributes(key("title").value("최대주주 현황")),
                                fieldWithPath("corpCode")
                                        .type(JsonFieldType.STRING)
                                        .description("공시대상회사의 고유번호")
                                        .attributes(key("constraints")
                                                .value("8자리")),
                                fieldWithPath("bsnsYear")
                                        .type(JsonFieldType.STRING)
                                        .description("사업연도")
                                        .attributes(key("constraints")
                                                .value("4자리")),
                                fieldWithPath("reprtCode")
                                        .type(JsonFieldType.STRING)
                                        .description("보고서 코드\n1분기보고서:11013\n반기보고서:11012\n3분기보고서:11014\n사업보고서:11011")
                                        .attributes(key("constraints")
                                                .value("5자리"))),
                        responseFields(
                                attributes(key("title").value("최대주주 현황")),
                                fieldWithPath("status").type(JsonFieldType.STRING).description("에러 및 정보 코드"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("에러 및 정보 메시지"),
                                fieldWithPath("bsns_year").type(JsonFieldType.STRING).optional().description("사업연도"),
                                fieldWithPath("reprt_code").type(JsonFieldType.STRING).optional().description("보고서코드"),
                                fieldWithPath("list.[].rcept_no").type(JsonFieldType.STRING).description("접수번호").attributes(key("constraints").value("14자리")),
                                fieldWithPath("list.[].corp_cls").type(JsonFieldType.STRING).description("법인구분 : Y(유가), K(코스닥), N(코넥스), E(기타)"),
                                fieldWithPath("list.[].corp_code").type(JsonFieldType.STRING).description("고유번호").attributes(key("constraints").value("공시대상회사의 고유번호(8자리)")),
                                fieldWithPath("list.[].corp_name").type(JsonFieldType.STRING).description("법인명"),
                                fieldWithPath("list.[].nm").type(JsonFieldType.STRING).description("성명"),
                                fieldWithPath("list.[].relate").type(JsonFieldType.STRING).optional().description("관계\n본인, 친인척 등"),
                                fieldWithPath("list.[].stock_knd").type(JsonFieldType.STRING).description("주식 종류\n보통주 등"),
                                fieldWithPath("list.[].bsis_posesn_stock_co").type(JsonFieldType.STRING).description("기초 소유 주식 수").attributes(key("constraints").value("9,999,999,999")),
                                fieldWithPath("list.[].bsis_posesn_stock_qota_rt").type(JsonFieldType.STRING).description("기초 소유 주식 지분 율").attributes(key("constraints").value("0.00")),
                                fieldWithPath("list.[].trmend_posesn_stock_co").type(JsonFieldType.STRING).description("기말 소유 주식 수").attributes(key("constraints").value("9,999,999,999")),
                                fieldWithPath("list.[].trmend_posesn_stock_qota_rt").type(JsonFieldType.STRING).description("기말 소유 주식 지분 율").attributes(key("constraints").value("0.00")),
                                fieldWithPath("list.[].rm").type(JsonFieldType.STRING).description("비고")
                        )
                ));
    }

}
