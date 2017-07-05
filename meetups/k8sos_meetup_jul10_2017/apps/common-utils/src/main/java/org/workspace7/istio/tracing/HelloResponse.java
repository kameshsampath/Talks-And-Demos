package org.workspace7.istio.tracing;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kameshs
 */
@Data
public class HelloResponse {

    private List<String> responses = new ArrayList<>();
}
