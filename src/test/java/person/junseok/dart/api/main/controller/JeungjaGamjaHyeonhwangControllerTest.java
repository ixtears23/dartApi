package person.junseok.dart.api.main.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import person.junseok.dart.api.main.dto.BusinessReportDTO;

import static org.springframework.restdocs.snippet.Attributes.attributes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

import static org.springframework.restdocs.snippet.Attributes.key;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;


@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(uriScheme = "http", uriHost = "localhost", uriPort = 12345)
public class JeungjaGamjaHyeonhwangControllerTest {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;
    private RestDocumentationResultHandler restDocumentationResultHandler;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public JeungjaGamjaHyeonhwangControllerTest() {
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
    public void jeungjaGamjaHyeonhwang() throws Exception {
        BusinessReportDTO businessReportDTO = BusinessReportDTO.builder()
                .bsnsYear("2018")
                .corpCode("00126380")
                .reprtCode("11011")
                .build();

        ResultActions resultAction = mockMvc.perform(post("/jeungjaGamjaHyeonhwang")
                .content(objectMapper.writeValueAsString(businessReportDTO))
                .contentType(MediaType.APPLICATION_JSON_VALUE));

        //ConstrainedFields fields = new ConstrainedFields(BusinessReportDTO.class);

        resultAction.andExpect(status().isOk())
                .andDo(restDocumentationResultHandler.document(
                        requestFields(
                                attributes(key("title").value("증자(감자) 현황")),
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
                                fieldWithPath("status").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("message").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("bsns_year").type(JsonFieldType.STRING).optional().description(""),
                                fieldWithPath("reprt_code").type(JsonFieldType.STRING).optional().description(""),
                                fieldWithPath("list.[].rcept_no").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].corp_cls").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].corp_code").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].corp_name").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].isu_dcrs_de").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].isu_dcrs_stle").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].isu_dcrs_stock_knd").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].isu_dcrs_qy").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].isu_dcrs_mstvdv_fval_amount").type(JsonFieldType.STRING).description(""),
                                fieldWithPath("list.[].isu_dcrs_mstvdv_amount").type(JsonFieldType.STRING).description("")
                        )
                ));
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }

}
