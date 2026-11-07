package org.example.aichatbot.aitools;

import jdk.jfr.Description;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTool {
    @Tool(description = """
            Performs arithmetic calculations.
            Supported Operations are : add,subtract,divide,multiply,mod,power.""")
    public double calculate(
            @ToolParam(description = "Operation: add,subtract,divide,multiply,mod,power")
            String operation,
            @ToolParam(description = "First Number")
            double a,
            @ToolParam(description = "First Number")
            double b
    ) {
        if(operation.equals("add")) return a + b;
        if(operation.equals("subtract")) return a - b;
        if(operation.equals("multiply")) return a * b;
        if(operation.equals("divide")) {
            if(b == 0) throw new IllegalArgumentException("Cannot Divide by 0");
            return a / b;
        }
        if(operation.equals("mod")) {
            if(b == 0) throw new IllegalArgumentException("Cannot calculate mod by 0");
            return a % b;
        }
        if(operation.equals("power")) return Math.pow(a,b);
        throw new IllegalArgumentException("Unsupported Operation cannot be performed");
    }

}

