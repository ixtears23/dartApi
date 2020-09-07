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
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs
public class IsaGamsaGaebyeolBosuHyeonhwangControllerTest {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;
    private RestDocumentationResultHandler restDocumentationResultHandler;

    public IsaGamsaGaebyeolBosuHyeonhwangControllerTest() {
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
    public void isaGamsaGaebyeolBosuHyeonhwangTest() throws Exception {
        SaeobBogoseoRequestDTO saeobBogoseoRequestDTO = SaeobBogoseoRequestDTO.builder()
                .bsnsYear("2018")
                .corpCode("00126380")
                .reprtCode("11011")
                .build();

        ResultActions resultAction = mockMvc.perform(post("/isaGamsaGaebyeolBosuHyeonhwang")
                .content(objectMapper.writeValueAsString(saeobBogoseoRequestDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        //ConstrainedFields fields = new ConstrainedFields(BusinessReportDTO.class);

        resultAction.andExpect(status().isOk())
                .andDo(restDocumentationResultHandler.document(
                        requestFields(
                                attributes(key("title").value("이사 감사 개별 보수현황")),
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
                                attributes(key("title").value("이사 감사 개별 보수현황")),
                                fieldWithPath("status").type(JsonFieldType.STRING).description("에러 및 정보 코드").attributes(key("constraints").value("" +
                                        "000:정상" +
                                        "010:등록되지 않은 키입니다." +
                                        "011:사용할 수 없는 키입니다. 오픈API에 등록되었으나. 일시적으로 중지된 키를 통하여 검색하는 경우 발생합니다." +
                                        "020:요청 제한을 초과하였습니다." +
                                        "일반적으로는 10,000건 이상의 요청에 대하여 이 에러 메시지가 발생되나, 요청 제한이 다르게 설정된 경우에는 이에 준하여 발생됩니다." +
                                        "100:필드의 부적절한 값입니다. 필드 설명에 없는 값을 사용한 경우에 발생하는 메시지입니다." +
                                        "800:원활한 공시서비스를 위하여 오픈API 서비스가 중지 중입니다." +
                                        "900:정의되지 않은 오류가 발생하였습니다.")),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("에러 및 정보 메시지"),
                                fieldWithPath("bsns_year").type(JsonFieldType.STRING).optional().description(""),
                                fieldWithPath("reprt_code").type(JsonFieldType.STRING).optional().description(""),
                                fieldWithPath("list.[].rcept_no").type(JsonFieldType.STRING).description("접수번호").attributes(key("constraints").value("14자리")),
                                fieldWithPath("list.[].corp_cls").type(JsonFieldType.STRING).description("법인구분"),
                                fieldWithPath("list.[].corp_code").type(JsonFieldType.STRING).description("고유번호"),
                                fieldWithPath("list.[].corp_name").type(JsonFieldType.STRING).description("법인명"),
                                fieldWithPath("list.[].nm").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("list.[].ofcps").type(JsonFieldType.STRING).optional().description("직위"),
                                fieldWithPath("list.[].mendng_totamt").type(JsonFieldType.STRING).description("보수 총액"),
                                fieldWithPath("list.[].mendng_totamt_ct_incls_mendng").type(JsonFieldType.STRING).description("보수 총액 비 포함 보수")
                        )
                ));
    }
}
